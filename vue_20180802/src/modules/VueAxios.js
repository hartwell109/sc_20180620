exports.install = function (Vue, options) {
    var axios = require('axios')
    var config = require('./config')
    const Axios = axios.create(config.axios)
    Vue.prototype.$axios = {get: Axios.get, post: Axios.post}
}
