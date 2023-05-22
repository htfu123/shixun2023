<template>
  <el-table
    :data="tableData_user"
    style="width: 100%">
    <el-table-column
      prop="user_name"
      label="姓名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="identity"
      label="身份"
      width="180">
    </el-table-column>
  </el-table>
</template>

<script>
import axios from "axios";

export default {
  created() {
    var _this = this
        axios({
          method:"post",
          headers:{
            'Content-Type':'application/json',
          },
          data:JSON.stringify(this.tableData_user),
          url:"http://127.0.0.1:8000/api/check_user/"
        }).then((res)=>{
         _this.tableData_user=res.data;
      })
  },
  data() {
    return {
      // tableData: [{
      //   user_name: '2016-05-02',
      //   user_pwd: '王小虎',
      // },
      //   {
      //     user_name: '2016-05-02',
      //     user_pwd: '管理员'
      //   }
      // ]
      tableData_user: []
    }
  }
}
</script>
