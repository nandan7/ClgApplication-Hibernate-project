package dao;

import java.util.List;

import model.Apply;

public interface ApplyDaoInterface {
    void insertApplication(Apply apply) throws ClassNotFoundException;
    List<Apply> displayAll() throws ClassNotFoundException;
    void deleteApply(String firstname);
}
