package cn.shopay.template;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import cn.shopay.template.entity.Company;
import cn.shopay.template.entity.User;
import cn.shopay.template.service.CompanyService;
import cn.shopay.template.service.UserService;

/**
 * @description 测试类
 * @author Yuanzhi.Xu
 * @version 1.0
 * @date 2020-05-06
 */
@ActiveProfiles("dev")
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class AppTest {

    static Logger logger = LoggerFactory.getLogger(AppTest.class);

    @Autowired
    private UserService userService;
    @Autowired
    private CompanyService companyService;

    @Test
    public void test() {
        
        logger.info("====================== 用户 =========================");
        String userName = "Dave";
        User user = userService.findByName(userName);
        if (user != null) {
            logger.info("用户[" + userName + "]已经存在！");
            logger.info("创建时间为：" + user.getCreateTimeText() + "，创建人为：" + user.getCreateBy());
        } else {
            logger.warn("用户[" + userName + "]不存在，即将添加用户");
            user = new User();
            user.setName(userName);
            if (userService.save(user)) {
                logger.info("用户[" + userName + "]添加成功");
            } else {
                logger.error("用户[" + userName + "]添加失败");
            }
        }

        logger.info("====================== 公司 =========================");
        Company new1 = new Company();
        new1.setName("NAME-" + System.currentTimeMillis());
        new1.setAddress("Nanjing city, Jiangsu province");
        if (companyService.save(new1)) {
            logger.info("公司[" + new1.getName() + "]添加成功");
        } else {
            logger.error("公司[" + new1.getName() + "]添加失败");
        }
        
        List<Company> list = companyService.findLikeAddr("Nanjing");
        if (list != null && list.size() > 0) {
            logger.info("查询到[" + list.size() + "]条公司数据");
        } else {
            logger.warn("没有查询到公司数据");
        }
    }
}
