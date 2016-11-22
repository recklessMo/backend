package com.recklessmo.dao.page;

import com.recklessmo.model.Page.Frame;
import com.recklessmo.web.webmodel.page.Page;

import java.util.List;

/**
 * Created by hpf on 11/22/16.
 */
public interface FrameDAO {

    void addFrame(Frame frame);
    List<Frame> listFrames(Page page);
    int listFramesCount(Page page);

}
