<template>
    <div id="login">
        <h1>{{title}}</h1>
        <input v-model="title"/><br/>
    </div>
</template>

<script>
    export default {
        name: 'Login',
        data: function () {
            return {
                title: 'Welcome to Login.'
            }
        }
    }
</script>

<style scoped>

</style>
