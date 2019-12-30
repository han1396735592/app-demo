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
        private int type;
        private String showMsg;
        private String method;
        private String methodParam;
        private String serviceName;
        private String serviceParam;
        private String intentName;
        private String intentParam;

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

        public String getMethodParam() {
            return methodParam;
        }

        public void setMethodParam(String methodParam) {
            this.methodParam = methodParam;
        }

        public String getServiceName() {
            return serviceName;
        }

        public void setServiceName(String serviceName) {
            this.serviceName = serviceName;
        }

        public String getServiceParam() {
            return serviceParam;
        }

        public void setServiceParam(String serviceParam) {
            this.serviceParam = serviceParam;
        }

        public String getIntentName() {
            return intentName;
        }

        public void setIntentName(String intentName) {
            this.intentName = intentName;
        }

        public String getIntentParam() {
            return intentParam;
        }

        public void setIntentParam(String intentParam) {
            this.intentParam = intentParam;
        }
    }
}
