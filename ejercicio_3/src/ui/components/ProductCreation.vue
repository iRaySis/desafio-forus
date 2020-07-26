<template>
  <div class="card">
    <div class="card-header">
      <p class="card-header-title">
        {{ isCreationMode? "Crear" : "Actualizar" }} Producto {{productoId? ` con id ${productoId}` : ''}}
      </p>
    </div>
    
    <div class="card-content">
      <ValidationObserver ref="observer" v-slot="{ }">
        <ValidationProvider rules="required" name="Name" v-slot="{ errors, valid }">
          <b-field :errors="errors" :type="{ 'is-danger': errors[0], 'is-success': valid }" :message="errors" label="Nombre">
              <b-input v-model="productoNombre"></b-input>
          </b-field>
        </ValidationProvider>
        <ValidationProvider rules="required" name="Description" v-slot="{ errors, valid }">
          <b-field :type="{ 'is-danger': errors[0], 'is-success': valid }" :message="errors" label="Descripción">
              <b-input v-model="productoDescripcion"></b-input>
          </b-field>
        </ValidationProvider>
        <ValidationProvider rules="required" name="Quantity" v-slot="{ errors, valid }">
          <b-field :type="{ 'is-danger': errors[0], 'is-success': valid }" :message="errors" label="Cantidad">
              <b-input type="Number" v-model="productoCantidad"></b-input>
          </b-field>
        </ValidationProvider>
        <b-field label="N° Localidad">
            <b-input  type="Number" v-model="productoUbicacion"></b-input>
        </b-field>
      
        <b-button :loading="isLoading" type="is-primary" @click="validateAndSave()">{{ isCreationMode? "Crear": "Actualizar"}}</b-button>
      </ValidationObserver>
    </div>
  </div>
</template>

<script>
import { saveProduct, updateProduct } from '../../application/services/dummyApi.js';
import { ValidationObserver, ValidationProvider } from "vee-validate";

export default {
  name:'product-creation',
  components: {
    ValidationObserver,
    ValidationProvider
  },
  mounted() {
    if ( !this.id ) {
      this.isCreationMode = true;
    }
    this.productoId = this.id;
    this.productoNombre = this.name;
    this.productoDescripcion = this.description;
    this.productoCantidad = this.quantity;
    this.productoUbicacion = this.location;
  },
  props: {
    useExternalApi: Boolean,
    id: Number,
    name: String,
    description: String,
    quantity: Number,
    location: Number
  },
  data() {
    return {
      isLoading: false,
      isCreationMode: false,
      productoId: undefined,
      productoNombre: '',
      productoDescripcion: '',
      productoCantidad: 0,
      productoUbicacion: undefined
    }
  },
  methods: {
    async validateAndSave() {
      const validation = await this.$refs.observer.validate()
      if ( validation ) {
        this.saveProduct();
      }
    },
    async saveProduct () {
      this.isLoading = true;
      const values = {
        productoId: this.productoId,
        productoNombre: this.productoNombre,
        productoDescripcion: this.productoDescripcion,
        productoCantidad: this.productoCantidad,
        productoUbicacion: this.productoUbicacion
      }
      const response = {};
      if ( this.productoId ) {
        this.response = await updateProduct(values, this.useExternalApi);
      } else {
        this.response = await saveProduct(values, this.useExternalApi);
      }
      
      if (response.errorMessage) {
         this.$emit(
           "save-status",
            {
              message: response.errorMessage,
              sucess: false
            });
       } else {
         this.$emit(
           "save-status",
            {
              message: 'Producto guardado correctamente',
              sucess: true
            });
         this.cleanData () ;
       }
       this.isLoading = false;
    },
    cleanData () {
      this.productoId = undefined;
      this.productoNombre = '';
      this.productoDescripcion = '';
      this.productoCantidad = undefined;
      this.productoUbicacion = undefined;
    }
  }
}
</script>