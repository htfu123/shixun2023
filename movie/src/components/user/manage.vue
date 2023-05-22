<template>
<!--  管理模型-->
  <el-table
    :data="tableData_model"
    style="width: 100%"
    :default-sort = "{prop: 'paraId', order: 'ascending'}"
    max-height="800px">
    <el-table-column
    prop="username"
    label="用户名"
    width="300">
  </el-table-column>
    <el-table-column
      prop="paraId"
      label="Id"
      sortable
      width="180">
    </el-table-column>
    <el-table-column
      prop="modname"
      label="模型名"
      width="300">
    </el-table-column>
    <el-table-column
      prop="nickname"
      label="名称"
      width="300">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="150">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent="deleteRow(scope.$index, tableData_model)"
          type="text"
          size="small">
          移除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
</template>

<script>
import axios from "axios";

export default {
  methods: {
    //删除模型方法
    deleteRow(index, rows) {
      let paraId = rows[index].paraId
      this.$http.post("/user/delMod",{paraId}).then((res)=>{
        this.tableData_model.splice(index,1)
      })
    },

  },
  created() {
    var _this = this
        axios({
          method:"get",
          headers:{
            'Content-Type':'application/json',
          },
          url:"/user/getModel"
        }).then((res)=>{
         _this.tableData_model=res.data;
      })
          .catch(() => {});
  },
  data() {
    return {
      tableData_model: [

      ]
    }
  }
}
</script>
