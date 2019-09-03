package com.chang.test.tree;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

/**
 * 构建树结构
 */
@Getter
@Setter
public class TreeEntity {
    private int id;  //节点的id值
    private int pid; //当前节点对应父节点的id值
    private String name; //节点的名称
    List<TreeEntity> nodes;
    public static void main(String[] args) {
        TreeEntity treeEntity1 = new TreeEntity();
        treeEntity1.setId(1);
        treeEntity1.setName("根节点");

        TreeEntity treeEntity2 = new TreeEntity();
        treeEntity2.setId(2);
        treeEntity2.setPid(1);
        treeEntity2.setName("节点1");

        TreeEntity treeEntity3 = new TreeEntity();
        treeEntity3.setId(3);
        treeEntity3.setPid(1);
        treeEntity3.setName("节点2");

        TreeEntity treeEntity4 = new TreeEntity();
        treeEntity4.setId(4);
        treeEntity4.setPid(3);
        treeEntity4.setName("节点3");

        List<TreeEntity> list = new ArrayList<>();
        list.add(treeEntity1);
        list.add(treeEntity2);
        list.add(treeEntity3);
        list.add(treeEntity4);

        List<TreeEntity> treeList =  groupMenuList(1,list);
        System.out.println(treeList);

    }


    //根据id和pId进行递归
    public static List<TreeEntity> groupMenuList(int pid,List<TreeEntity> list){
        List<TreeEntity> menuList = new ArrayList<>();
        for (TreeEntity treeEntity:list) {
            if(treeEntity.getPid() == pid){
                List<TreeEntity> childList = groupMenuList(treeEntity.getId(),list);
                treeEntity.setNodes(childList);
                menuList.add(treeEntity);
            }
        }
        return menuList;
    }
}
