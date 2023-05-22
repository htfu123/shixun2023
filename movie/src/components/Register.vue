<template>
  <el-form ref="RegisterFormRef" :model="registerForm" label-width="0" :rules="RegisterFormRules" class="register_form">
    <span class="Register_title">Creat an account</span> <br/>
    <span class="Register_text">Let's get started</span>
    <el-form-item prop="username">
      <!-- 用户名-->
      <el-input placeholder="用户名" v-model="registerForm.username" prefix-icon="el-icon-user" style="margin-top: 15px"></el-input>
    </el-form-item>
    <!-- 密码-->
    <el-form-item prop="password">
      <el-input placeholder="密码" v-model="registerForm.password" prefix-icon="el-icon-lock" type="password"></el-input>
    </el-form-item>
    <!-- 重复密码-->
    <el-form-item prop="passwordAgain">
      <el-input placeholder="重复输入密码" v-model="registerForm.passwordAgain" prefix-icon="el-icon-lock" type="password"></el-input>
    </el-form-item>
    <el-form-item class="btns">
      <el-button class="register_button" type="success" @click="register">注册</el-button> <br />
      <el-button class="reset_button" type="info" @click="resetRegisterForm">重置</el-button> <br />
      <span>Already have an account?</span> <el-button type="text" @click="login">Log in</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from "axios";
import Login from "./Login";
export default {
  data(){
    return{
      // 注册的初始化数据：备注默认应该是空
      registerForm:{
        username:'',
        password:'',
        passwordAgain:''
      },
      // 正则表达式的相关校验
      RegisterFormRules:{
        username:[
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        password:[
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
        passwordAgain:[
          { required: true, message: '请再次输入密码', trigger: 'blur' },
        ]
      }
    }
  },
  methods:{
    // 清空表单的校验
    resetRegisterForm() {
      this.$refs.RegisterFormRef.resetFields();
    },
    //注册
    login(){
      window.location.reload();
    },

    register(){
      if(this.registerForm.username!=''&&this.registerForm.password!=''&&this.registerForm.passwordAgain!='')
      {
        if(this.registerForm.password===this.registerForm.passwordAgain)
        {
          axios({
            method:"post",
            headers:{
              'Content-Type':'application/json',
            },
            data:JSON.stringify(this.registerForm),
            url:"/users/register"
          }).then(res => {
            console.log(res)
            if (res.data.code=='20')
              this.$message.error('用户名重复，注册失败！');
            if (res.data.code=='2')
              this.$message({
                message: '注册成功！',
                type: 'success'
              });
          })
        }
        else
          this.$message({
            message: '请输入两次相同的密码！',
            type: 'warning'
          });
      }
      else
        this.$message({
          message: '输入不能为空！',
          type: 'warning'
        });
    }
  },
  name: "Register",
}
</script>

<style lang="less" scoped>
.register_form{
  bottom: 0;
  width: 100%;
  padding: 20px;
  box-sizing: border-box;
  height: 500px;
}

.btns{
  justify-content:flex-end;
  height: 25px;
}

.register{
  margin-left: 25px;
  height: 30px;
}

span.Register_title{
  margin-right: 93px;
  color:black;
  font-size: 40px;
  font-weight: bold;
  line-height: 60px;
}

span.Register_text{
  margin-right: 320px;
  color:gray;
  font-size: 10px;
  font-weight: bold;
}

.register_button{
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

</style>
