package ro.agitman.menta.action;

import org.mentawai.core.BaseAction;
import ro.agitman.menta.entity.Advert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by gitmaal on 23/09/2015.
 */
public class IndexAction extends BaseAction {

    public String execute() throws Exception {
        List<Advert> myList = new ArrayList<>();
        Advert advert = new Advert();
        advert.setDescription("abc");
        advert.setPrice(new BigDecimal("123"));
        myList.add(advert);

        advert = new Advert();
        advert.setDescription("def");
        advert.setPrice(new BigDecimal("222"));
        myList.add(advert);

        advert = new Advert();
        advert.setDescription("ghi");
        advert.setPrice(new BigDecimal("333"));
        myList.add(advert);

        String search = input.getString("search");
        if(search!=null && !search.isEmpty()){
            Iterator<Advert> it = myList.iterator();
            while(it.hasNext()){
                Advert ad = it.next();
                if(!ad.getDescription().contains(search)){
                    it.remove();
                }
            }
        }

        output.setValue("myList", myList);

        return SUCCESS;
    }

}
