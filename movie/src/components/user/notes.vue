<template>
<!--  训练结果-->
  <div style="background-color:  #e4ecf5">
  <el-table
    :data="tableData_rec"
    stripe
    style="width: 100%"
    :default-sort = "{prop: 'id', order: 'ascending'}"
    max-height="800px">
    <el-table-column
      prop="id"
      label="编号"
      sortable
      width="100">
    </el-table-column>
    <el-table-column
      prop="modname"
      label="模型名"
      sortable
      width="100">
    </el-table-column>
    <el-table-column
      prop="acc"
      label="正确率"
      sortable
      width="170">
    </el-table-column>
    <el-table-column
      prop="trp"
      label="trp"
      width="170">
    </el-table-column>
    <el-table-column
      prop="size"
      label="大小"
      width="100">
    </el-table-column>
    <el-table-column
      prop="ppv"
      label="ppv"
      width="170">
    </el-table-column>
    <el-table-column
      prop="fn"
      label="fn"
      width="60">
    </el-table-column>
    <el-table-column
      prop="tn"
      label="tn"
      width="60">
    </el-table-column>
    <el-table-column
      prop="fp"
      label="fp"
      width="60">
    </el-table-column>
    <el-table-column
      prop="tp"
      label="tp"
      width="100">
    </el-table-column>
    <el-table-column
      prop="f1"
      label="f1"
      width="170">
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="80">
      <template slot-scope="scope">
        <el-button
          @click.native.prevent="deleteRow(scope.$index, tableData_rec)"
          type="text"
          size="small">
          移除
        </el-button>
      </template>
    </el-table-column>
  </el-table>
  </div>
</template>

<script>
import axios from "axios";

export default {
  methods: {
    deleteRow(index, rows) {
      let id = rows[index].id
      this.$http.post("/user/delTrain", {id}).then((res) => {
        this.tableData_rec.splice(index, 1)
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
      url:"/user/getTrain"
    }).then((res)=>{
      _this.tableData_rec=res.data;
    })
  },
  data() {
    return {
      tableData_rec: [

  ],

    }
  },

}
</script>
