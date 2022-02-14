package sda.hibernate.przyklad7;

import sda.hibernate.dao.UserCriteriaDao;

public class Przyklad7 {
    public static void main(String[] args) {
        UserCriteriaDao userCriteriaDao = new UserCriteriaDao();
        userCriteriaDao.findUserWhereNameContains("sk")
                .forEach(System.out::println);

    }
}
