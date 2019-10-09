package com.teaching.dto;

import lombok.Data;

/**
 * @Author： XO
 * @Description：
 * @Date： 2019/10/9 11:15
 */

@Data
public final class QiNiuPutRet {
    public String key;
    public String hash;
    public String bucket;
    public int width;
    public int height;

}
