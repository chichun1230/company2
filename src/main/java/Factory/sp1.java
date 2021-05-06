package Factory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import Dao.memberDao;
import Dao.porderDao;
import Model.member;
import Model.porder;

@Configuration
public class sp1 {
	@Bean(name = "m")
	public member getM() {
		return new member();
	}
	@Bean(name = "p")
	public porder getP() {
		return new porder();
	}
	@Bean(name = "md")
	public memberDao getMd() {
		return new memberDao();
	}
	@Bean(name = "pd")
	public porderDao getPd() {
		return new porderDao();
	}

	@Bean(name = "sf")
	public SpFactory getSF() {
		SpFactory sp = new SpFactory();
		sp.setM(getM());
		sp.setP(getP());
		sp.setMd(getMd());
		sp.setPd(getPd());
		return sp;
	}
}
