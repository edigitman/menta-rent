package ro.agitman.menta;

import org.mentabean.DBTypes;
import org.mentabean.jdbc.MySQLBeanSession;
import org.mentawai.action.LogoutAction;
import org.mentawai.core.ApplicationManager;
import org.mentawai.core.Props;
import org.mentawai.db.BoneCPConnectionHandler;
import org.mentawai.db.ConnectionHandler;
import org.mentawai.filter.AuthenticationFilter;
import ro.agitman.menta.action.HelloAction;
import ro.agitman.menta.action.IndexAction;
import ro.agitman.menta.action.LoginAction;
import ro.agitman.menta.dao.impl.UserDaoImpl;
import ro.agitman.menta.entity.Address;
import ro.agitman.menta.entity.Advert;
import ro.agitman.menta.entity.Image;
import ro.agitman.menta.entity.User;

import javax.jws.soap.SOAPBinding;
import java.math.BigDecimal;
import java.util.Date;

public class AppManager extends ApplicationManager {

	public static final String PAGE_INDEX = "/jsp/index.jsp";
	public static final String PAGE_LOGIN = "/jsp/login.jsp";
	public static final String PAGE_SETTINGS = "/jsp/settings.jsp";

	@Override
	public void loadActions() {
        //AUTHENTICATION ACTIONS
        action("/Login", LoginAction.class)
                .on(SUCCESS, fwd(PAGE_SETTINGS))
                .on(ACCESSDENIED, fwd(PAGE_LOGIN));
        action("/Logout", LogoutAction.class)
                .on(SUCCESS, redir(PAGE_INDEX));

        action("/Index", IndexAction.class)
                .bypassAuthentication()
                .on(SUCCESS, fwd(PAGE_INDEX));

        //GENERIC ACTIONS
        action("/Hello", HelloAction.class, "hi")
			.on(SUCCESS, fwd(PAGE_INDEX));
		
	}

    @Override
    public void setupIoC() {

        ioc("beanSession", MySQLBeanSession.class);
        ioc("userDao", UserDaoImpl.class);
    }

    // GENERIC FILTERS
    @Override
    public void loadFilters() {

        filter(new AuthenticationFilter());
        on(LOGIN, redir(PAGE_LOGIN));
    }

    // DATABASE CONFIGURATIONS
	@Override
	public ConnectionHandler createConnectionHandler() {
		Props props = getProps();
		String driver = props.getString("jdbc.driver");
		String url = props.getString("jdbc.url");
		String user = props.getString("jdbc.user");
		String pass = props.getString("jdbc.pass");
		return new BoneCPConnectionHandler(driver, url, user, pass);
    }

    @Override
    public void loadBeans() {
        bean(User.class, "USERS")
                .pk("ID", DBTypes.AUTOINCREMENT)
                .field("email", DBTypes.STRING)
                .field("alias", DBTypes.STRING)
                .field("password", DBTypes.STRING)
                .field("token", DBTypes.STRING)
                .field("confirmed", DBTypes.BOOLEANINT);

        bean(Address.class, "ADDRESS")
                .pk("ID", DBTypes.AUTOINCREMENT)
                .field("city", DBTypes.ENUMVALUE.from(Address.City.class))
                .field("street", DBTypes.STRING)
                .field("nr", DBTypes.STRING)
                .field("building", DBTypes.STRING)
                .field("staircase", DBTypes.STRING)
                .field("floor", DBTypes.STRING)
                .field("flat", DBTypes.STRING)
                .field("lng", DBTypes.BIGDECIMAL)
                .field("lat", DBTypes.BIGDECIMAL)
                .field("cp", DBTypes.STRING);

        bean(Advert.class, "ADVERTS")
                .pk("id", DBTypes.AUTOINCREMENT)
                .field("description", DBTypes.STRING)
                .field("buildingType", DBTypes.ENUMVALUE.from(Advert.BuildingType.class))
                .field("dateFrom", DBTypes.DATE)
                .field("dateUntil", DBTypes.DATE)
                .field("price", DBTypes.BIGDECIMAL)
                .field("deposit", DBTypes.BIGDECIMAL)
                .field("negotiable", DBTypes.BOOLEANINT)
                .field("currency", DBTypes.ENUMVALUE.from(Advert.Currency.class))
                .field("noRooms", DBTypes.INTEGER)
                .field("sqrm", DBTypes.BIGDECIMAL)
                .field("features", DBTypes.LONG)
                .field("buildingyear", DBTypes.INTEGER);

        bean(Image.class, "IMAGES")
                .pk("id", DBTypes.AUTOINCREMENT)
                .field("cloudinaryId", DBTypes.STRING);
    }
}