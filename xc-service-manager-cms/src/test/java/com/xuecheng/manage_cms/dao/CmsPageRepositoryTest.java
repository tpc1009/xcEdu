package com.xuecheng.manage_cms.dao;

import com.xuecheng.framework.domain.cms.CmsPage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsPageRepositoryTest {

    @Autowired
    private CmsPageRepository cmsPageRepository;

    @Test
    public void findAll(){
        List<CmsPage> list = this.cmsPageRepository.findAll();
        System.out.println("++++++++++++++++++++");
        list.stream().forEach((s)-> System.out.println(s));
        System.out.println("++++++++++++++++++++++");
    }

    @Test
    public void findPage(){
        int page =0;
        int size = 10;
        PageRequest request = new PageRequest(page,size);

        Page<CmsPage> list = this.cmsPageRepository.findAll(request);
        list.stream().forEach((s)-> System.out.println(s));
    }

    @Test
    public void update(){
        Optional<CmsPage> optianl = this.cmsPageRepository.findById("5abefd525b05aa293098fca6");
        if(optianl.isPresent()){
            CmsPage cmsPage = optianl.get();
            cmsPage.setPageAliase("test002");
            this.cmsPageRepository.save(cmsPage);
        }
    }

}
