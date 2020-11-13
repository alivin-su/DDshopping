<template>
  <div>
    <el-tree
      :data="menus"
      :props="defaultProps"
      :expand-on-click-node="false"
      show-checkbox="true"
      node-key="catId"
      :default-expanded-keys="expandedKey"
    >
      <span class="custom-tree-node" slot-scope="{ node, data }">
        <span>{{ node.label }}</span>
        <span>
          <el-button
            v-if="node.level <= 2"
            type="text"
            size="mini"
            @click="() => append(data)"
          >
            Append
          </el-button>
          <el-button
            type="text"
            size="mini"
            @click="() => edit(data)"
          >
            Edit
          </el-button>
          <el-button
            v-if="node.childNodes.length == 0"
            type="text"
            size="mini"
            @click="() => remove(node, data)"
          >
            Delete
          </el-button>
        </span>
      </span>
    </el-tree>
    <el-dialog title="提示" :visible.sync="dialogVisible">
      <el-form :model="category">
        <el-form-item label="活动名称">
          <el-input v-model="category.name" autocomplete="off"></el-input>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="addCategory()">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
export default {
  data() {
    return {
      category:{name : "",parentCid:0, catLevel:0,solt:0,showStatus:1},
      dialogVisible : false,
      menus: [],
      expandedKey: [],
      defaultProps: {
        children: "children",
        label: "name",
      },
    };
  },
  methods: {
    getMenus() {
      this.$http({
        url: this.$http.adornUrl("/product/category/list/tree"),
        method: "get",
      }).then(({ data }) => {
        console.log("成功获取菜单数据", data.data);
        this.menus = data.data;
      });
    },
    append(data) {
      console.log(data);
      //设置对话框属性为true显示对话框
      this.dialogVisible = true;
      this.category.parentCid = data.catId;
      this.catLevel = data.catLevel*1 +1 ;
    },
    addCategory(){
       this.$http({
            url: this.$http.adornUrl("/product/category/save"),
            method: "post",
            data: this.$http.adornData(this.category, false),
          }).then(()=>{
              this.$message({
              message: "菜单添加成功！",
              type: "sucess",
            });
            this.dialogVisible = false;
            this.getMenus();
            this.expandedKey = [this.category.data.catId];
            //设置需要默认展开的菜单
          })
    },
    remove(node, data) {
      var ids = [data.catId];
      this.$confirm(`是否删除当前菜单${data.name}?`, "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.$http({
            url: this.$http.adornUrl("/product/category/delete"),
            method: "post",
            data: this.$http.adornData(ids, false),
          }).then(({ data }) => {
            this.$message({
              message: "删除成功！",
              type: "sucess",
            });
            this.getMenus();
            //设置需要默认展开的菜单
            this.expandedKey = [node.parent.data.catId];
          });
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "已取消删除",
          });
        });
    },
  },
  created() {
    this.getMenus();
  },
};
</script>
<style>
</style>


