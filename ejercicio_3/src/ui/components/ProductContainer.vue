<template>
  <div>
    <section class="hero is-primary">
      <div class="hero-body">
        <div class="container">
          <h1 class="title">
            Mantenedor de productos <i class="fas fa-boxes"></i>
          </h1>
          <h2 class="subtitle">
            (Ejercicio 3)
          </h2>
        </div>
      </div>
    </section>
    <div class="principal-body">
      <div class="api-switch">
        <b-switch 
          v-model="useExternalApi"
          passive-type='is-dark'
          type='default'>
          {{ useExternalApi ? "Forus Dummy Api (Ejercicio 2)" : "My Rest Api (Ejercicio 1)" }}
        </b-switch>
      </div>
      <div class="maintainer-options">
        <b-field grouped group-multiline>
        <b-field>
          <b-button rounded @click="openCreationModal()" >
            Crear Producto <i class="fas fa-box"></i>
          </b-button>
        </b-field>
        <b-field>
          <b-tooltip label="Actualizar productos"> 
          <b-button :loading="isLoading" rounded @click="getDummyObject(true)">
             <i class="fas fa-sync"></i>
          </b-button>
          </b-tooltip>
        </b-field>
      </b-field>
      </div>
      <div class="notification" v-if="!products || products.length === 0">
        <h3>No hay productos que mostrar</h3>
      </div>
      <div class="products" v-if="products && products.length > 0">
        <div class="card product" v-for="item in products" :key="item.productoId">
          <Product :name=item.productoNombre :id=item.productoId :description=item.productoDescripcion
            :quantity=item.productoCantidad :location=item.productoUbicacion :useExternalApi=useExternalApi
            v-on:reloadProducts="getDummyObject(false)" v-on:openUpdateModal="openUpdateModal"/>
        </div>
      </div>
    </div>
    <b-modal :active.sync="isModalActive"
      has-modal-card
      trap-focus
      :destroy-on-hide="true"
      aria-role="dialog"
      aria-modal>
      <ProductCreation v-on:save-status="saveAlert" :useExternalApi="useExternalApi"
        :id="selectedItem.id" :name="selectedItem.name" :description="selectedItem.description" :quantity="selectedItem.quantity"
        :location="selectedItem.location"/>
    </b-modal>
    <b-loading :is-full-page="true" :active.sync="isLoading"></b-loading>
  </div>
</template>

<script>
import { getProduct } from '../../application/services/dummyApi.js';
import Product from './Product';
import ProductCreation from './ProductCreation';

export default {
  name:'product-container',
  components: {
    Product,
    ProductCreation
  },
  data() {
    return {
      products: [],
      useExternalApi: false,
      requestUrl: '',
      isLoading: false,
      isModalActive: false,
      selectedItem: {
        id: undefined,
        name: '',
        description: '',
        quantity: undefined,
        location: undefined
      }
    }
  },
  watch: {
    useExternalApi() {
      this.getDummyObject();
    }
  },
  mounted() {
    this.getDummyObject();
  },
  methods: {
    async getDummyObject(showAlert = false) {
      this.isLoading = true;
       const response = await getProduct(this.useExternalApi);
       let alertMessage = {};
       if (response.errorMessage) {
         this.products = [];
          alertMessage = { message: response.errorMessage, type: 'is-danger' };
       } else {
         alertMessage = { message: 'Se han obtenido los productos correctamente!', type: 'is-success' };
         this.products = response;
       }
       if (showAlert) {
           this.responseAlert(alertMessage.message, alertMessage.type);
        } 
       this.isLoading = false;
    },
    responseAlert(message, type = 'is-success') {
      this.$buefy.notification.open({
        duration: 1500,
        message,
        type,
        queue: false
      })
    },
    openCreationModal() {
      this.selectedItem = {
        id: undefined,
        name: '',
        description: '',
        quantity: undefined,
        location: undefined
      };
      this.isModalActive = true;
    },
    openUpdateModal(itemData) {
      this.selectedItem = itemData;
      this.isModalActive = true;
    },
    async saveAlert(value) {
      if ( value.sucess ) {
        this.isModalActive = false;
        this.responseAlert(value.message);
        this.getDummyObject();
      }
      console.log(value);
    }
  }
}
</script>

<style lang="css" scoped>
.notification {
  margin: 30px;
}
.api-switch {
  margin: 10px;
}
.field.is-grouped-multiline.is-grouped {
  justify-content: center;
}
.principal-body {
  margin-top: 40px;
  position: relative;
}
.principal-body .products {
  margin-left: 8%;
  padding: 20px;
}
.product {
  margin: 10px 5px;
  width: 30%;
  float: left;
}

@media (max-width: 650px) {
  .principal-body .products {
  margin: 0px;
  padding: 20px;
  }
  .product {
    margin: 0px 0px;
    width: 100%;
    float: left;
  }
}

</style>