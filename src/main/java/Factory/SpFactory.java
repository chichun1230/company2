package Factory;

import Dao.memberDao;
import Dao.porderDao;
import Model.member;
import Model.porder;

public class SpFactory {
	private member m;
	private porder p;
	private memberDao md;
	private porderDao pd;

	public SpFactory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SpFactory(member m, porder p, memberDao md, porderDao pd) {
		super();
		this.m = m;
		this.p = p;
		this.md = md;
		this.pd = pd;
	}

	public member getM() {
		return m;
	}

	public void setM(member m) {
		this.m = m;
	}

	public porder getP() {
		return p;
	}

	public void setP(porder p) {
		this.p = p;
	}

	public memberDao getMd() {
		return md;
	}

	public void setMd(memberDao md) {
		this.md = md;
	}

	public porderDao getPd() {
		return pd;
	}

	public void setPd(porderDao pd) {
		this.pd = pd;
	}

}
