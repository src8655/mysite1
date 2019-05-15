package com.cafe24.mysite.action.board;

import com.cafe24.web.mvc.Action;
import com.cafe24.web.mvc.ActionFactory;

public class BoardActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		if("write".equals(actionName)) {
			action = new WriteAction();
		}else if("writepost".equals(actionName)) {
			action = new WritePostAction();
		}else if("view".equals(actionName)) {
			action = new ViewAction();
		}else if("modify".equals(actionName)) {
			action = new ModifyAction();
		}else if("modifypost".equals(actionName)) {
			action = new ModifyPostAction();
		}else if("delete".equals(actionName)) {
			action = new DeleteAction();
		}else {
			action = new ListAction();
		}
		return action;
	}

}
