package com.boon.inform;

import com.boon.inform.mapper.InformMapper;
import com.boon.inform.service.InformService;
import com.boon.pojo.Inform;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.bind.annotation.PathVariable;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * author:       HeJin
 * Date:         2020/1/23
 * version:      1.0
 * Description:  关于这个类的描述
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class InformTest {

    @Autowired
    private InformMapper informMapper;

    @Autowired
    private InformService informService;

    @Test
    public void addInform(){
        Inform inform = new Inform();
        inform.setTitle("寒假放假通知");
        inform.setContent("各位同学，第7个学期已经结束，寒假来临了。我们下个学期的重头戏是两门课程：毕业设计及论文答辩；自主实习。请大家提前准备。\n" +
                "开学后毕业设计环节的步骤如下：论文修改-论文定稿-论文检测-论文答辩。\n" +
                "自主实习：评定成绩需要提交的资料如下：附件1（实习单位接收证明）、附件2（安全协议书）、专业自主实习报告（第二阶段）。请已经完成或正在" +
                "自主实习的同学积极收集资料，完成以上三个文档，开学就可以开始提交有关资料了。\n");
        inform.setUserSno("2016901138");
        inform.setCreateTime(new Timestamp(new Date().getTime()));
        boolean b = informService.addInform(inform);
        System.out.println(b);
    }

    @Test
    public void findById(){
        Inform inform = informService.findById(1);
        System.out.println(inform);
    }

    @Test
    public void findAll(){
        List<Inform> informs = informService.findAll("2016901147",null,null,null);
        for (Inform inform : informs) {
            System.out.println(inform);
        }
    }

    @Test
    public void findBySno(){
        List<Inform> informs = informService.findBySno("2016901147");
        for (Inform inform : informs) {
            System.out.println(inform);
        }
    }

    @Test
    public void update(){
        Inform inform = informService.findById(1);
        inform.setUserSno("0");
        inform.setTitle("关于寒假放假通知");
        inform.setContent("各位同学，第7个学期已经结束，寒假来临了。我们下个学期的重头戏是两门课程：毕业设计及论文答辩；自主实习。请大家提前准备。\n" +
                "开学后毕业设计环节的步骤如下：论文修改-论文定稿-论文检测-论文答辩。\n" +
                "自主实习：评定成绩需要提交的资料如下：附件1（实习单位接收证明）、附件2（安全协议书）、专业自主实习报告（第二阶段）。请已经完成或正在" +
                "自主实习的同学积极收集资料，完成以上三个文档，开学就可以开始提交有关资料了。\n");
        inform.setCreateTime(new Timestamp(new Date().getTime()));
        boolean b = informService.update(inform);
        System.out.println(b);

    }

    @Test
    public void delete(){
        boolean b = informService.delete(1);
        System.out.println(b);
    }

    @Test
    public void findCount(){
        Integer count = informService.findCount();
        System.out.println(count);
    }

}
