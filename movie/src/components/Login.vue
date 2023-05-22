<template>
  <el-container class="login_container">
    <el-card :body-style="{ padding: '0px' }"  class="box-card">
      <!--图片走马灯-->
      <div class="block">
        <el-carousel trigger="click" height="600px" :interval="6000"	 style="width:775px">
          <el-carousel-item v-for="item in imgbox  " :key="item.id">
            <img :src="item.img" class="tu" width="775px" height="600px">
          </el-carousel-item>
        </el-carousel>
      </div>

      <div class="login_box">

        <el-tabs class="tabs" v-model="activeName">
          <el-tab-pane label="登录" name="first">
            <span class="Login_title">Log in</span> <br/>
            <span class="Login_text">Welcome back! Please enter your details</span>
            <!-- 表单 -->
            <el-form ref="LoginFormRef" :model="loginForm" label-width="0" :rules="LoginFormRules" class="login_form">
              <!--登录-->
              <el-form-item prop="username">
                <!-- 用户名-->
                <el-input  placeholder="用户名" v-model="loginForm.username" prefix-icon="el-icon-user"></el-input>
              </el-form-item>
              <!-- 密码-->
              <el-form-item prop="password">
                <el-input placeholder="密码" v-model="loginForm.password" prefix-icon="el-icon-lock" type="password"></el-input>
              </el-form-item>
              <el-form-item class="btns">
                <el-button class="login_button" type="primary" @click="login">登录</el-button> <br />
                <el-button class="reset_button" type="info" @click="resetLoginForm">重置</el-button> <br />
                <span>Don't have an account?</span> <el-button type="text" @click="register">Sign up</el-button>


              </el-form-item>
            </el-form>
          </el-tab-pane>
          <el-tab-pane label="注册" name="second">
            <!--            注册组件-->
            <register></register>
          </el-tab-pane>
        </el-tabs>
      </div>
    </el-card>

  </el-container>

</template>

<script>
//引入注册组件
import register from "./Register";
import axios from "axios";
export default {
  data() {
    return {
      activeName: 'first',
      // 登录的初始化数据：备注默认应该是空
      loginForm:{
        identity:'用户',
        username:'',
        password:''
      },
      // 正则表达式的相关校验
      LoginFormRules:{
        username:[
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        password:[
          { required: true, message: '请输入密码', trigger: 'blur' },
        ]
      },
      imgbox: [
        { id: 0, img: require("../assets/t1.jpg") },
        { id: 1, img: require("../assets/t2.jpg") },
        { id: 2, img: require("../assets/t3.jpg") },
        { id: 3, img: require("../assets/t4.jpg") },
        { id: 4, img: require("../assets/t5.jpg") }
      ]
    }
  },
  methods: {
    // 清空表单的校验
    resetLoginForm() {
      this.$refs.LoginFormRef.resetFields()
    },
    //登录的方法：登录逻辑写里面

    register() {
      this.activeName="second";
    },

    login1() {
      this.activeName="first";
    },

    login() {
      if (this.loginForm.username != '' && this.loginForm.password != '') {
        axios({
          method:"post",
          headers:{
            'Content-Type':'application/json',
          },
          data:JSON.stringify(this.loginForm),
          url:"http://localhost:8080/users/login"
        }).then(res => {
          console.log(res.data)
          if (res.data.code=='10')
            this.$message.error('密码错误，登陆失败！');
          else
          {
            this.$message({
              message: '登录成功！',
              type: 'success'
            });
            localStorage.setItem("token",res.data.data)
            this.$router.push("/user3");

          }
        })
      }
      else
        this.$message({
          message: '输入不能为空！',
          type: 'warning'
        });

    }
  },
  components: {
    register
  }
}
</script>

<style lang="less" scoped>
.login_container{
  background-color: #c0ccda;
  height: 100%;
  background-image: url("../assets/bg2.jpg");
  background-size: 100% 100%;

}
.login_box{
  width: 475px;
  height: 600px;
  background-color: #fff;
  border-radius: 3px;
  margin-left: 1012px;
  transform: translate(-50%,-97%);
  box-shadow: 0 0 10px #ddd;
}

.box-card{
  position: absolute;
  transform: translate(15%,15%);
  margin-left:150px;
  margin-top:55px;
  height: 600px;
  width:1250px;
  border-radius: 2px;
  border-top:none;border-bottom:none;border-left: none;border-right: none;
}

.block{
  height: 580px;
  width:600px;
}

span.Login_title{
  margin-right: 300px;
  color:black;
  font-size: 40px;
  font-weight: bold;
  line-height: 60px;
}

span.Login_text{
  margin-right: 180px;
  color:gray;
  font-size: 10px;
  font-weight: bold;
}

.login_form{
  bottom: 0;
  width: 100%;
  padding: 20px;
  box-sizing: border-box;
}

.login_button{
  width: 300px;
  background-color:  black;
  border-color: black;
}

.reset_button{
  width: 300px;
  margin-top: 15px;
  background-color: white;
  color: black;
}

.btns{
  justify-content:flex-end;
  height: 250px;
}



.tabs{
  padding-top: 15px;
  padding-left: 10px;
}

</style>>
