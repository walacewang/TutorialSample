package com.kalphix.config.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Handler�C���^�[�Z�v�^�[�N���X
 * 
 * @author kalphix
 *
 */

public class UhandlerInterceptorInfra extends HandlerInterceptorAdapter {

	/** Logger */
	private static Logger LOGGER = LoggerFactory.getLogger(UhandlerInterceptorInfra.class);

	/**
	 * �R���g���[���[�̃��\�b�h�N�����s����O�Z�b�V�����������s���B
	 * 
	 * @param ���N�G�X�g
	 * @param ���X�|���X
	 * @param �n���h��
	 * @return �㑱��������
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// ���N�G�X�g�������O�o�͂���
		LOGGER.error(/* UstringUtil.getRequestInfo(request) */"adie;adadawfadwefpov;fd log");

		// TODO remember to delete.
		System.out.println(">>> preHandle");

		// TODO dump request info to log file for debug.

		// if not login �F�؃N�b�L�[�`�F�b�N
//		if (!request.getServletPath().equals("/login")) {
//
//			Cookie[] cookies = request.getCookies();
//			boolean authed = false;
//			for (int i = 0; cookies != null && i < cookies.length; i++) {
//				Cookie cookie = cookies[i];
//				if ("wea.auth".equals(cookie.getName())) {
//					authed = true;
//					break;
//				}
//			}
//			if (!authed) {
//				response.sendRedirect(request.getContextPath() + "/login");
//				return false;
//			}
//		}

		return true;
	}

	/**
	 * 
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO remember to delete.
		System.out.println(">>> postHandle respnonse's status=" + response.getStatus());
	}

	/**
	 * 
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO remember to delete.
		System.out.println(">>> afterCompletion respnonse's status=" + response.getStatus());
	}

}
