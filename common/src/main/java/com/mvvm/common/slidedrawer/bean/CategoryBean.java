package com.mvvm.common.slidedrawer.bean;

import java.util.List;

import androidx.annotation.Keep;

public class CategoryBean {

        /**
         * types : 16
         * typename : 分类
         * child : [{"id":22,"isCheck":false,"typename":"原石"},{"id":23,"isCheck":false,"typename":"挂件"},{"id":24,"isCheck":false,"typename":"耳饰"},{"id":26,"isCheck":false,"typename":"手饰"},{"id":36,"isCheck":false,"typename":"项链"},{"id":37,"isCheck":false,"typename":"摆件"},{"id":38,"isCheck":false,"typename":"配饰"},{"id":39,"typename":"头饰"},{"id":40,"isCheck":false,"typename":"把件"},{"id":41,"isCheck":false,"typename":"器皿件"},{"id":42,"isCheck":false,"typename":"珠子"},{"id":43,"isCheck":false,"typename":"杂项"},{"id":70,"isCheck":false,"typename":"戒指"},{"id":71,"isCheck":false,"typename":"吊坠"},{"id":74,"isCheck":false,"typename":"手镯"},{"id":75,"isCheck":false,"typename":"玉牌"},{"id":78,"isCheck":false,"typename":"皮带扣"}]
         */

        private int types;
        private String type ;
        private String typename;
        private List<ChildBean> child;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getTypes() {
            return types;
        }

        public void setTypes(int types) {
            this.types = types;
        }

        public String getTypename() {
            return typename;
        }

        public void setTypename(String typename) {
            this.typename = typename;
        }

        public List<ChildBean> getChild() {
            return child;
        }

        public void setChild(List<ChildBean> child) {
            this.child = child;
        }
        @Keep
        public static class ChildBean {
            /**
             * id : 22
             * isCheck : false
             * typename : 原石
             */
            private String itemId ;
            private int id;
            private boolean isCheck; //标签是否被选中
            private String typename;

            public String getItemId() {
                return itemId;
            }

            public void setItemId(String itemId) {
                this.itemId = itemId;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isIsCheck() {
                return isCheck;
            }

            public void setIsCheck(boolean isCheck) {
                this.isCheck = isCheck;
            }

            public String getTypename() {
                return typename;
            }

            public void setTypename(String typename) {
                this.typename = typename;
            }
        }
}
