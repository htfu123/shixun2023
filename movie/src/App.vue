<template>
  <div id="app">
<!--     <a href="#/button">显示button</a>-->
<!--    <a href="#/login">登录</a>-->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',


  data: () => ({
    //
  }),
}


</script>

<style>
html,
body,
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  height: 100%;
  margin: 0;
  padding: 0
}
</style>
