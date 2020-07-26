import Vue from 'vue'
import App from './ui/App.vue'
import Buefy from 'buefy'
import 'buefy/dist/buefy.css'
import "./vee-validate";
import '@fortawesome/fontawesome-free/css/all.css'
import '@fortawesome/fontawesome-free/js/all.js'

Vue.config.productionTip = false
Vue.use(Buefy)

new Vue({
  render: h => h(App),
}).$mount('#app')
