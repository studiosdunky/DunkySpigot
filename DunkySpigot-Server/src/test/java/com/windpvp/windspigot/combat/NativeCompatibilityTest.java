package com.windpvp.windspigot.combat;

import com.velocitypowered.natives.compression.VelocityCompressor;
import com.velocitypowered.natives.encryption.VelocityCipher;
import com.velocitypowered.natives.util.MoreByteBufUtils;
import com.velocitypowered.natives.util.Natives;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.UnpooledByteBufAllocator;
import org.junit.Test;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.assertArrayEquals;

public class NativeCompatibilityTest {
    @Test public void compressionRoundTrip() throws Exception {
        byte[] text = "DunkySpigot Java 8 compression round trip".getBytes(StandardCharsets.UTF_8);
        try (VelocityCompressor compressor = Natives.compress.get().create(-1)) {
            ByteBuf input = MoreByteBufUtils.preferredBuffer(UnpooledByteBufAllocator.DEFAULT, compressor, text.length);
            ByteBuf compressed = MoreByteBufUtils.preferredBuffer(UnpooledByteBufAllocator.DEFAULT, compressor, 256);
            ByteBuf restored = MoreByteBufUtils.preferredBuffer(UnpooledByteBufAllocator.DEFAULT, compressor, text.length);
            try {
                input.writeBytes(text);
                compressor.deflate(input, compressed);
                compressor.inflate(compressed, restored, text.length);
                byte[] actual = new byte[restored.readableBytes()]; restored.readBytes(actual);
                assertArrayEquals(text, actual);
            } finally { input.release(); compressed.release(); restored.release(); }
        }
    }

    @Test public void cipherRoundTrip() throws Exception {
        byte[] text = "DunkySpigot Java 8 cipher round trip".getBytes(StandardCharsets.UTF_8);
        SecretKeySpec key = new SecretKeySpec(new byte[16], "AES");
        try (VelocityCipher encryption = Natives.cipher.get().forEncryption(key);
             VelocityCipher decryption = Natives.cipher.get().forDecryption(key)) {
            ByteBuf buffer = MoreByteBufUtils.preferredBuffer(UnpooledByteBufAllocator.DEFAULT, encryption, text.length);
            try {
                buffer.writeBytes(text); encryption.process(buffer); decryption.process(buffer);
                byte[] actual = new byte[buffer.readableBytes()]; buffer.readBytes(actual);
                assertArrayEquals(text, actual);
            } finally { buffer.release(); }
        }
    }
}
