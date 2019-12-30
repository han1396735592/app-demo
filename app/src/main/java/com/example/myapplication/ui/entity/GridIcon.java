package com.example.myapplication.ui.entity;

public class GridIcon {
    private String title;
    private String imgSrc;
    private Action action;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public class Action {
        public static final int ACTION_TYPE_SHOW = 1;
        public static final int ACTION_TYPE_METHOD = 2;
        public static final int ACTION_TYPE_SERVICE = 3;
        public static final int ACTION_TYPE_INTENT = 4;
        public static final int ACTION_TYPE_ACTIVITY = 5;
        private int type;
        private String showMsg;
        private String method;
        private Object[] methodParam;
        private String serviceName;
        private Object[] serviceParam;
        private String intentName;
        private Object[] intentParam;
        private String activity;

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getShowMsg() {
            return showMsg;
        }

        public void setShowMsg(String showMsg) {
            this.showMsg = showMsg;
        }

        public String getMethod() {
            return method;
        }

        public void setMethod(String method) {
            this.method = method;
        }

        public Object[] getMethodParam() {
            return methodParam;
        }

        public void setMethodParam(Object[] methodParam) {
            this.methodParam = methodParam;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getIntentName() {
            return intentName;
        }

        public void setIntentName(String intentName) {
            this.intentName = intentName;
        }

        public Object[] getServiceParam() {
            return serviceParam;
        }

        public void setServiceParam(Object[] serviceParam) {
            this.serviceParam = serviceParam;
        }

        public Object[] getIntentParam() {
            return intentParam;
        }

        public void setIntentParam(Object[] intentParam) {
            this.intentParam = intentParam;
        }
    }
}
