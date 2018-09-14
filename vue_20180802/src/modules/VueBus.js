exports.install = function (Vue, options) {
    let bus = new Vue()
    Vue.prototype.$bus = bus
}
