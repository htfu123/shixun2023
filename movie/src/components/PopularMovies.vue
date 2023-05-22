<template>
  <el-container>
    <el-row :gutter="250" class="row" >
      <el-col :span="4" offset="1 " v-for="movie in movies" :key="movie.id" class="col">
        <MovieCard :movie="movie" :genres="genres"/>
      </el-col>
    </el-row>
  </el-container>
</template>

<script>
import MovieCard from '../components/MovieCard'
export default {
  components :{
    MovieCard,
  },
  data: function (){
    return {
      movies: [
        { id:1,name:'zs1',img: require("../assets/t1.jpg")},
        { id:2,name:'zs2',img: require("../assets/t2.jpg")},
        { id:3,name:'zs3',img: require("../assets/t3.jpg")},
        { id:4,name:'zs4',img: require("../assets/t4.jpg")},
        { id:5,name:'zs1',img: require("../assets/t5.jpg")},
        { id:6,name:'zs2',img: require("../assets/t1.jpg")},
        { id:7,name:'zs3',img: require("../assets/t1.jpg")},
      ],
      genres: [

      ]
    };
  },
  async created(){
    this.fetchGenres();
    try {
      // const response = await this.$http.get("/movie/popular");
      const response = await this.$http.get("/v1/images/search?format=json&limit=20");
      console.log("response: ", response.data);
      this.movies = response.data;
    }catch (error) {
      console.log(error);
    }
  },
  methods: {
    async fetchGenres() {
      try {
        const response = await this.$http.get("/genre/movie/list");
        this.genres = response.data.genres;
      }catch (error) {
        console.log(error);
      }
    }
  }
}
</script>

<style>

.row{
  margin-top: 0px;
  margin-bottom: 300px;
}

</style>
<!--<style>-->
<!--  @import'~bootstrap/dist/css/bootstrap.css';-->
<!--</style>-->
