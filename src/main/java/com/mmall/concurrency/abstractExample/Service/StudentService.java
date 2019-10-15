package com.mmall.concurrency.abstractExample.Service;

/**
 * @author grace
 * @date   2019/10/15
 * @description 规范学生行为
 */
public interface StudentService {
    /**
     * 读书
     * @param bookName
     */
    void readBook(String bookName);

    /**
     * 写作
     * @return 一篇文章
     */
    String writeArticle();

    /**
     * 查成绩
     * @param courseNo 课程编号
     * @return 分数
     */
    int getScore(String courseNo);
}
