<template>
  <el-table
    :data="tableData_feedback"
    style="width: 100%">
    <el-table-column
      prop="user_name_id"
      label="用户名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="feed"
      label="反馈内容"
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
          data:JSON.stringify(this.tableData_feedback),
          url:"http://127.0.0.1:8000/api/check_feedback/"
        }).then((res)=>{
         _this.tableData_feedback=res.data;
      })
  },
  data() {
    return {
      tableData_feedback: []
    }
  }
}
</script>
