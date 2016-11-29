package com.recklessmo.web.webmodel.page;

import java.util.List;

/**
 * Created by hpf on 11/29/16.
 */
public class AboutPage {

    class People{
        private String pic;
        private String name;
        private String intro;

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }
    }

    private String firstImg;
    private String companyIntro;
    private List<People> leaderPicList;
    private List<People> teamPicList;
    private String companyCulture;
    private String corpText;
    private String resumePost;


    public List<People> getTeamPicList() {
        return teamPicList;
    }

    public void setTeamPicList(List<People> teamPicList) {
        this.teamPicList = teamPicList;
    }

    public String getFirstImg() {
        return firstImg;
    }

    public void setFirstImg(String firstImg) {
        this.firstImg = firstImg;
    }

    public String getCompanyIntro() {
        return companyIntro;
    }

    public void setCompanyIntro(String companyIntro) {
        this.companyIntro = companyIntro;
    }

    public List<People> getLeaderPicList() {
        return leaderPicList;
    }

    public void setLeaderPicList(List<People> leaderPicList) {
        this.leaderPicList = leaderPicList;
    }

    public String getCompanyCulture() {
        return companyCulture;
    }

    public void setCompanyCulture(String companyCulture) {
        this.companyCulture = companyCulture;
    }

    public String getCorpText() {
        return corpText;
    }

    public void setCorpText(String corpText) {
        this.corpText = corpText;
    }

    public String getResumePost() {
        return resumePost;
    }

    public void setResumePost(String resumePost) {
        this.resumePost = resumePost;
    }
}
