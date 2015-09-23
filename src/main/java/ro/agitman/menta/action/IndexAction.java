package ro.agitman.menta.action;

import org.mentawai.core.BaseAction;
import ro.agitman.menta.entity.Advert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gitmaal on 23/09/2015.
 */
public class IndexAction extends BaseAction {

    public String execute() throws Exception {

        List<Advert> myList = new ArrayList<>();
        Advert advert = new Advert();
        advert.setDescription("desc1");
        advert.setPrice(new BigDecimal("123"));
        myList.add(advert);

        advert = new Advert();
        advert.setDescription("desc2");
        advert.setPrice(new BigDecimal("222"));
        myList.add(advert);

        advert = new Advert();
        advert.setDescription("desc3");
        advert.setPrice(new BigDecimal("333"));
        myList.add(advert);

        output.setValue("myList", myList);

        return SUCCESS;
    }

}
