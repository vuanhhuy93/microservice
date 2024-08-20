package com.huyva.base.common;

public enum USER_STATUS {
   ACTIVE(1),
        INACTIVE(0)
    ;
        private int status;



        USER_STATUS(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
}
