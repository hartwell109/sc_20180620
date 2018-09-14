// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import VueAxios from './modules/VueAxios'
import VueQs from './modules/VueQs'
import VueBus from './modules/VueBus'

Vue.config.productionTip = false

Vue.use(VueAxios)
Vue.use(VueQs)
Vue.use(VueBus)

/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    components: {App},
    template: '<App/>'
})
