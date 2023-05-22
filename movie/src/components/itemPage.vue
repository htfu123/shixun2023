<template>
  <div class="item">
    <!-- 设置插槽 -->
    <slot></slot>
  </div>
</template>

<script>
export default {};
</script>

<style>
.item {
  height: 300px;
  /* 外边距20px */
  margin: 20px;
  background-color: white;
}
</style>
