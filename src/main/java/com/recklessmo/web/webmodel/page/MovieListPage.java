package com.recklessmo.web.webmodel.page;

import java.util.List;

/**
 * Created by hpf on 11/29/16.
 */
public class MovieListPage {

    private ImgObject firstHead;
    private ImgObject secondHead;
    private ImgObject thirdHead;

    private List<ImgObject> movList;
    private List<ArticleObject> articleObjectList;


    public ImgObject getFirstHead() {
        return firstHead;
    }

    public void setFirstHead(ImgObject firstHead) {
        this.firstHead = firstHead;
    }

    public ImgObject getSecondHead() {
        return secondHead;
    }

    public void setSecondHead(ImgObject secondHead) {
        this.secondHead = secondHead;
    }

    public ImgObject getThirdHead() {
        return thirdHead;
    }

    public void setThirdHead(ImgObject thirdHead) {
        this.thirdHead = thirdHead;
    }

    public List<ImgObject> getMovList() {
        return movList;
    }

    public void setMovList(List<ImgObject> movList) {
        this.movList = movList;
    }

    public List<ArticleObject> getArticleObjectList() {
        return articleObjectList;
    }

    public void setArticleObjectList(List<ArticleObject> articleObjectList) {
        this.articleObjectList = articleObjectList;
    }
}
