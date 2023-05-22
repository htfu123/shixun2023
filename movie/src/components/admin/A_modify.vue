<template>
  <el-form style="margin-top:180px" label-width="10px" :label-position="labelPosition" ref="LoginFormRef" :model="user" class="login_form">
    <el-form-item  label="用户名" prop="username">
      <el-input :disabled="true" style="width: 500px" placeholder="用户名" v-model="user.username" prefix-icon="el-icon-user"></el-input>
    </el-form-item>
    <el-form-item label="密码" prop="password">
      <el-input style="width: 500px" placeholder="密码" v-model="user.password" prefix-icon="el-icon-lock"></el-input>
    </el-form-item>
    <el-form-item class="btns">
      <el-button type="primary" @click="submit">修改</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
import axios from "axios";

export default {
  mounted() {
    var _this = this
    axios({
      method:"get",
      headers:{
        'Content-Type':'application/json',
      },
      url:"http://127.0.0.1:8000/api/get_info/"
    }).then((res)=>{
      _this.user.username=res.data.username;
      _this.user.password=res.data.password;
      _this.newUser.username=res.data.username;
      _this.newUser.password=res.data.password;
    })
  },
  data() {
    return {
      labelPosition: 'top',
      user:{
        username: '',
        password:''
      },
      newUser:{
        username: '',
        password:''
      }
    }
  },
  methods:{
    submit(){
        axios({
          method:"post",
          headers:{
            'Content-Type':'application/json',
          },
          data:JSON.stringify(this.user),
          url:"http://127.0.0.1:8000/api/modify_a/"
        }).then(res => {
          if (res.data.loginMsg=='0')
          {
            this.$message({
              message: '修改成功！',
              type: 'success'
            });
          }
          if(res.data.loginMsg=='1')
          {
            this.$message.error('用户名重复，修改失败！');
            this.user.username=this.newUser.username;
            this.user.password=this.newUser.password;
          }
        })
    }
  }
}
</script>
