<template>
  <el-table
    :data="tableData_log"
    style="width: 100%">
    <el-table-column
      prop="user_name_id"
      label="用户名"
      width="180">
    </el-table-column>
    <el-table-column
      prop="operation"
      label="操作"
      width="180">
    </el-table-column>
    <el-table-column
      prop="ort_time"
      label="操作时间"
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
          data:JSON.stringify(this.tableData_log),
          url:"http://127.0.0.1:8000/api/check_log/"
        }).then((res)=>{
         _this.tableData_log=res.data;
      })
  },
  data() {
    return {
      tableData_log: []
    }
  }
}
</script>
