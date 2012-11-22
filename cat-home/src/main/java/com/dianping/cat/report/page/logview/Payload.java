package com.dianping.cat.report.page.logview;

import java.util.Arrays;

import com.dianping.cat.report.ReportPage;
import com.dianping.cat.report.page.AbstractReportPayload;
import org.unidal.web.mvc.ActionContext;
import org.unidal.web.mvc.payload.annotation.FieldMeta;
import org.unidal.web.mvc.payload.annotation.PathMeta;

public class Payload extends AbstractReportPayload<Action> {
	@FieldMeta("op")
	private Action m_action = Action.VIEW;

	@PathMeta("path")
	private String[] m_path;

	@FieldMeta("header")
	private boolean m_showHeader = true;
	
	@FieldMeta("waterfall")
	private boolean m_waterfall = false;

	public Payload() {
		super(ReportPage.LOGVIEW);
	}

	@Override
	public Action getAction() {
		return m_action;
	}

	public String[] getPath() {
		return m_path;
	}

	public boolean isShowHeader() {
		return m_showHeader;
	}

	public boolean isWaterfall() {
   	return m_waterfall;
   }

	public void setAction(String action) {
		m_action = Action.getByName(action, m_action);
	}

	public void setPath(String[] path) {
		if (path == null) {
			m_path = new String[0];
		} else {
			m_path = Arrays.copyOf(path, path.length);
		}
	}

	public void setShowHeader(String showHeader) {
		m_showHeader = !"no".equals(showHeader);
	}

	public void setWaterfall(boolean waterfall) {
   	m_waterfall = waterfall;
   }

	@Override
	public void validate(ActionContext<?> ctx) {
	}
}
