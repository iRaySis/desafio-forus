<template>
  <div>
    <div class="card-body">
      <h5 class="text-center card-title">{{name}}</h5>
      <ul>
        <li><span>ID:</span> {{id}}</li>
        <li><span>Descripción:</span> {{description}}</li>
        <li><span>Cantidad:</span> {{quantity}}</li>
        <li><span>Ubicación:</span> {{location}}</li>
      </ul>
      <div class="card-options">
        <b-button rounded :loading="isLoading"  type="is-warning" @click="openUpdateModal()">Modificar</b-button>
        <b-button rounded :loading="isLoading"  type="is-danger" @click="deleteProduct(id)">Eliminar</b-button>
      </div>
    </div>
  </div>
</template>

<script>
import { deleteProduct } from '../../application/services/dummyApi.js';

export default {
  name:'product',
  data() {
    return {
      isLoading: false
    }
  },
  props: {
    useExternalApi: Boolean,
    id: Number,
    name: String,
    description: String,
    quantity: Number,
    location: Number
  },
  methods: {
    async deleteProduct(productId) {
      this.isLoading = true;
      const response = await deleteProduct(productId, this.useExternalApi);
      if (response.errorMessage) {
         this.products = [];
         this.responseAlert(response.errorMessage, 'is-danger');
       } else {
         this.responseAlert(`Producto con id ${productId} eliminado correctamente!`);
         this.$emit('reloadProducts');
       }
       this.isLoading = false;
    },
    responseAlert(message, type = 'is-success') {
      this.$buefy.notification.open({
        duration: 1500,
        message,
        type
      })
    },
    openUpdateModal() {
      const actualProduct = {
        id: this.id, name: this.name, description: this.description, quantity: this.quantity, location: this.location
      }
      this.$emit('openUpdateModal', actualProduct);
    }
  }
}
</script>

<style lang="css" scoped>
li {
  text-align: left;
  padding-left: 40px;
}
.card-body span{
  font-weight: bold;
}
.card-title {
  font-weight: bold;
  padding: 30px;
  font-size: 20px
}
.card-options {
  margin-top: 5px;
}
.card-options .button {
  margin: 10px;
}

@media (max-width: 650px) {
  .card-options .button {
    width: 90%;
  }
}

</style>