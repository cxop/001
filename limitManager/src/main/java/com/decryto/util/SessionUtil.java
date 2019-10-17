package com.decryto.util;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * session帮助类
 */
public class SessionUtil {



    /**
     * 获取已经登录用户的session
     * @param request
     * @return
     */
    public static HttpSession getLoginSession(HttpServletRequest request){
        return request.getSession(false);
    }

    /**
     *
     * @param attrName key名称
     * @param tClass 要转换的class
     * @param session
     * @param <T>
     * @return
     */
    public static <T> T getAttribute(String attrName, Class<T> tClass, HttpSession session){
        if(session == null) return null;
        if(session.getAttribute(attrName) != null
                && session.getAttribute(attrName).getClass().equals(tClass)) {
            T t = (T) (session.getAttribute(attrName));
            return t;
        }else{
            return null;
        }
    }
    public static <T> T getAttribute(String attrName, Class<T> tClass,
                                     HttpSession session, boolean isClear){
        if(session == null) return null;
        if(session.getAttribute(attrName) != null
                && session.getAttribute(attrName).getClass().equals(tClass)) {
            T t = (T) (session.getAttribute(attrName));
            if(isClear)
                session.removeAttribute(attrName);
            return t;
        }else{
            return null;
        }
    }

    /**
     * session 设置属性
     * @param attrName
     * @param tClass
     * @param value
     * @param session
     * @param <T>
     * @return
     */
    public static <T> Boolean setAttribute(String attrName, Class<T> tClass, T value,  HttpSession session){
        if(session == null) return false;
        if(value != null && session != null) {
            session.setAttribute(attrName, value);
            return true;
        }else{
            return false;
        }
    }
}
