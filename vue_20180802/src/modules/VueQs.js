exports.install = function (Vue, options) {
    var qs = require('qs')
    Vue.prototype.$qs = {stringify: qs.stringify}
}
