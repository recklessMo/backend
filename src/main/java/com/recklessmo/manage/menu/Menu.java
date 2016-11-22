package com.recklessmo.manage.menu;

/**
 *
 * 返回menu菜单
 *
 * Created by hpf on 4/13/16.
 */
public class Menu{

    public static Menu[] menuList = {
            new Menu(100, null, "首页", "icon-book-open", "app.cover"),
            new Menu(200, null, "关于我们", "icon-book-open", "app.about"),
            new Menu(300, null, "电影", "icon-book-open", "app.film"),
            new Menu(400, null, "电视剧", "icon-book-open", "app.tv"),
            new Menu(500, null, "影视发行", "icon-book-open", "app.issue"),
            new Menu(600, null, "艺人管理", "icon-basket-loaded", "app.star"),
            new Menu(700, null, "帐号管理", "icon-settings", "app.account"),
            new Menu(800, null, "文件上传", "icon-settings", "app.upload"),
            new Menu(900, null, "新建页面", "icon-settings", "app.frame")
    };



    private long id;
    private String father;
    private String child;
    private String icon;
    private String href;

    public Menu(){

    }

    public Menu(long id, String father, String child, String icon, String href){
        this.id = id;
        this.father = father;
        this.child = child;
        this.icon = icon;
        this.href = href;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFather() {
        return father;
    }

    public void setFather(String father) {
        this.father = father;
    }

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}
