<template>
    <div>
        <h1>用户列表</h1>
        <br/>
        <button value="getToken" v-on:click="getList">获取Token</button>
        <table v-if="userlist.length" class="h1">
            <thead>
            <tr>
                <th></th>
                <th>userid</th>
                <th>username</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="(user,index) in userlist" v-bind:key="user.userId">
                <td>{{index+1}}</td>
                <td>{{user.userId}}</td>
                <td>{{user.username}}</td>
            </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: 'UserList',
        methods: {
            getList: function () {
                console.log('getToken......')
                let that = this
                let url = 'userbase/findall'
                let params = this.$qs.stringify({
                    // username: '78D9AD0F',
                    // password: '78D9AD0F',
                    // grant_type: 'password'
                })
                let headers = {
                    'Access-Control-Allow-Origin': '*',
                    'Access-Control-Allow-Credentials': 'true',
                    'Access-Control-Allow-Headers': 'Origin,X-Requested-With,Content-Type,Accept,Authorization',
                    'Authorization': 'bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1MzY4MTc5MjAsInVzZXJfbmFtZSI6Ijc4RDlBRDBGIiwiYXV0aG9yaXRpZXMiOlsiUk9MRV9BRE1JTiIsIlJPTEVfVVNFUiIsIlJPTEVfR1VFU1QiXSwianRpIjoiMjBkMjNkN2UtYTc4YS00NGFlLTk5YWItYzg1N2QzYzc3OWM0IiwiY2xpZW50X2lkIjoiZXVyZWthLWNsaWVudCIsInNjb3BlIjpbInNlcnZlciJdfQ.Z5ZnVKO2c5rgOFGrHVKoh-ckPNyVIGIO8TMx_WCq2Rg'
                }
                this.$axios.get(url, params, headers)
                    .then(function (response) {
                        console.log(response)
                        that.userlist = response.data.content
                    })
            }
        },
        data () {
            return {
                title: 'Welcome to UserList',
                userlist: []
            }
        }
    }
</script>

<style scoped>
    h1, .h1 {
        color: blue;
    }
</style>
