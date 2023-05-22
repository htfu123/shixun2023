<template>
  <el-card :body-style="{ padding: '0px' }" class="card" >
    <img :src="movie.img" class="image" width="300px" height="400px">
    <div style="padding: 14px;">
      <span>{{ movie.url }}</span>
      <div class="bottom clearfix">
        <time class="time">{{ movie.id }}</time>
        <el-button type="text" class="button">操作按钮</el-button>
      </div>
    </div>
  </el-card>
</template>

<script>

export default {
  data() {
    return {
      currentDate: new Date()
    };
  },
  props: {
    movie: {
      required: true,
    },
    genres: {
      required: true,
    }
  },

  // methods: {
  //   genreTypeName(genraId, index) {

  //     for(const item of this.genres) {
  //       if(item.id == genraId) {
  //         if(this.movie.genre_ids.length - 1 == index){
  //           return item.name ;
  //         }else {
  //           return item.name + ",";
  //         }

  //       }
  //     }
  //   }
  // }
}
</script>

<style>

.card{
  width: 400px;
  margin-top: 50px;
}

.time {
  font-size: 13px;
  color: #999;
}

.bottom {
  margin-top: 13px;
  line-height: 12px;
}

.button {
  padding: 0;
  float: right;
}



.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}

.clearfix:after {
  clear: both
}
</style>
