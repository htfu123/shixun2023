<template>
  <el-container style="height: 500px; border: 1px solid #eee">
    <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
      <el-menu :default-openeds="['1', '3']" @select="handleMenuSelect">
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-message"></i>导航一</template>
          <el-menu-item-group>
            <el-menu-item index="1">新增</el-menu-item>
            <el-menu-item index="2">修改</el-menu-item>
            <el-menu-item index="3">删除</el-menu-item>
          </el-menu-item-group>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>

      <el-main>
        <el-table :data="tableData">
          <el-table-column prop="cargo_id" label="id" width="140">
          </el-table-column>
          <el-table-column prop="cargo_name" label="商品名" width="120">
          </el-table-column>
          <el-table-column prop="cargo_start" label="起点">
          </el-table-column>
          <el-table-column prop="cargo_end" label="终点">
          </el-table-column>
          <el-table-column prop="cargo_num" label="数量">
          </el-table-column>
          <el-table-column prop="cargo_time" :formatter="dataFormat" label="生成时间">
          </el-table-column>
          <el-table-column prop="cargo_owner" label="拥有人">
          </el-table-column>

        </el-table>
      </el-main>
    </el-container>
    <el-dialog title="新增商品" :visible.sync="dialogVisible" width="30%">
      <el-form ref="form"  label-width="80px">
        <el-form-item label="商品名">
          <el-input v-model="sub.cargo_name"></el-input>
        </el-form-item>
        <el-form-item label="起点">
          <el-input v-model="sub.cargo_start"></el-input>
        </el-form-item>
        <el-form-item label="终点">
          <el-input v-model="sub.cargo_end"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input v-model="sub.cargo_num"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="submit">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog title="修改商品" :visible.sync="changeDia" width="30%">
      <el-form ref="form"  label-width="80px">
        <el-form-item label="id">
          <el-input v-model="chSub.cargo_id"></el-input>
        </el-form-item>
        <el-form-item label="数量">
          <el-input v-model="chSub.cargo_num"></el-input>
        </el-form-item>
        <el-form-item label="起点">
          <el-input v-model="chSub.cargo_start"></el-input>
        </el-form-item>
        <el-form-item label="终点">
          <el-input v-model="chSub.cargo_end"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="changeDia = false">取 消</el-button>
        <el-button type="primary" @click="change">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog title="修改商品" :visible.sync="deDia" width="30%">
      <el-form ref="form"  label-width="80px">
        <el-form-item label="id">
          <el-input v-model="id"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="deDia = false">取 消</el-button>
        <el-button type="primary" @click="dele">确 定</el-button>
      </span>
    </el-dialog>
  </el-container>

</template>


<style>

</style>

<script>
import axios from "axios";

export default {
  created() {
    this.token = localStorage.getItem('token')

    axios({
      method:"get",
      headers:{
        'Content-Type':'application/json',
        'Authorization': 'Bearer ' + this.token,
      },

      url:"http://localhost:8080/cargo/list"
    }).then(res => {
      console.log(res.data.data)
      if (res.data.code==30){
        this.$message.error('列表为空！');
      }else {
        this.tableData=res.data.data
        console.log(this.tableData)
      }
    })


  },
  data() {
    return {
      token: '',
      dialogVisible: false,
      changeDia: false,
      sub:{
        cargo_name: '',
        cargo_start: '',
        cargo_end: '',
        cargo_num: ''
      },
      chSub:{
        cargo_id: '',
        cargo_num: '',
        cargo_start: '',
        cargo_end: ''
      },
      id:'',
      deDia: false,
      tableData: [{
        cargo_id: '',
        cargo_name: '',
        cargo_start: '',
        cargo_end: '',
        cargo_num: '',
        cargo_time: '',
        cargo_owner: '',
        cargo_status: ''
      }]
    }
  },
  methods:{
    //修改时间格式
    dataFormat: function(row,column){
      let data = row[column.property]
      if (data ===null) {
        return ''
      }
      let dt = new Date(data)
      return dt.getFullYear() + '-' + (dt.getMonth() + 1) + '-' + dt.getDate()
    },
    handleMenuSelect(index) {
      console.log("当前选中的菜单项索引是：" + index);
      // 在这里可以编写菜单项的点击事件处理逻辑
      if (index == 1) this.add()
      else if(index == 2) this.getChange()
      else if(index == 3) this.getDele()
    },
    add(){
      console.log("增")
      this.dialogVisible = true
    },
    getChange(){
      this.changeDia = true
    },
    getDele(){
      this.deDia = true
    },
    change(){
      console.log(this.chSub)
      axios({
        method:"post",
        headers:{
          'Content-Type':'application/json',
          'Authorization': 'Bearer ' + this.token
        },
        data:JSON.stringify(this.chSub),
        url:"http://localhost:8080/cargo/edit"
      }).then(res => {
        this.$message.success('修改成功')
      })
      location.reload()

    },
    dele(){
      console.log("删")
      console.log(this.id)
      var id = this.id
      axios({
        method:"post",
        headers:{
          'Content-Type':'application/json',
          'Authorization': 'Bearer ' + this.token
        },
        url:"http://localhost:8080/cargo/delete/" +id
      }).then(res => {
        this.$message.success('删除成功')
      })
      location.reload()

    },
    submit(){
      // console.log(this.sub)
      axios({
        method:"post",
        headers:{
          'Content-Type':'application/json',
          'Authorization': 'Bearer ' + this.token,
        },
        data:JSON.stringify(this.sub),
        url:"http://localhost:8080/cargo/submit"
      }).then(res => {
        this.$message.success('提交成功')
      })
      // location.reload()
    }
  }
};
</script>
