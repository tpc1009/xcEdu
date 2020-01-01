package com.xuecheng.manage_cms.controller;

import com.xuecheng.api.cms.CmsPageControllerAPi;
import com.xuecheng.framework.domain.cms.request.QueryPageRequest;
import com.xuecheng.framework.model.response.QueryResponseResult;
import com.xuecheng.manage_cms.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController//相应的结果集转换为json
public class CmsPageController implements CmsPageControllerAPi {

    @Autowired
    private PageService pageService;

    
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(@PathVariable int page, @PathVariable int size) {

       /* QueryResult<CmsPage> queryResult= new QueryResult<>();
        ArrayList<CmsPage> list = new ArrayList<>();
        CmsPage cmsPage = new CmsPage();
        cmsPage.setPageName("测试页面");
        list.add(cmsPage);
        queryResult.setList(list);
        queryResult.setTotal(1);

        QueryResponseResult result = new QueryResponseResult(CommonCode.SUCCESS,queryResult);*/
        QueryPageRequest request = new QueryPageRequest();
        request.setPageAliase("test002");

        QueryResponseResult list = this.pageService.findList(page, size, request);
        return list;
    }


    @Override
    @GetMapping("/list/{page}/{size}")
    public QueryResponseResult findList(int page, int size, QueryPageRequest queryPageRequest) {
        return null;
    }
}
