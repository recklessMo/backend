package com.recklessmo.service.biz;

import com.recklessmo.dao.page.FrameDAO;
import com.recklessmo.model.Page.Frame;
import com.recklessmo.web.webmodel.page.Page;
import jdk.nashorn.internal.ir.annotations.Reference;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by hpf on 11/22/16.
 */
@Service
public class FrameService {

    @Resource
    private FrameDAO frameDAO;

    public void insert(Frame frame){
        frameDAO.addFrame(frame);
    }

    public List<Frame> listFrames(Page page){
        return frameDAO.listFrames(page);
    }

    public int listFramesCount(Page page){
        return frameDAO.listFramesCount(page);
    }

    public void updateContent(Frame frame){
        frameDAO.updateContent(frame);
    }

    public void deleteFrame(long id){
        frameDAO.deleteFrame(id);
    }

    public Frame getById(long id){
        return frameDAO.getById(id);
    }

}
