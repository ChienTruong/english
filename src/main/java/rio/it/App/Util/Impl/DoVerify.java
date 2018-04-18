package rio.it.App.Util.Impl;

import rio.it.App.Dto.*;

import java.util.List;

/**
 * Created by chien on 16/04/2018.
 */
public class DoVerify {

    private boolean allowNullMp3;
    private boolean allowNullQuestionList;
    private boolean allowNullParagraphList;
    private boolean allowNullFileImageList;
    private boolean allowNullSentenceList;
    private boolean allowNullAsk;
    private boolean allowNullSentence;
    private int maxSizeQuestionList;
    private int maxSizeSubQuestionList;
    private int minSizeSubQuestionList;
    private int maxSizeImageList;
    private int maxSizeSentenceList;

    public DoVerify(boolean allowNullMp3, boolean allowNullQuestionList, boolean allowNullParagraphList, boolean allowNullFileImageList, boolean allowNullSentenceList, boolean allowNullAsk, boolean allowNullSentence, int maxSizeQuestionList, int minSizeQuestionList, int maxSizeSubQuestionList, int maxSizeImageList, int maxSizeSentenceList) {
        this.allowNullMp3 = allowNullMp3;
        this.allowNullQuestionList = allowNullQuestionList;
        this.allowNullParagraphList = allowNullParagraphList;
        this.allowNullFileImageList = allowNullFileImageList;
        this.allowNullSentenceList = allowNullSentenceList;
        this.allowNullAsk = allowNullAsk;
        this.allowNullSentence = allowNullSentence;
        this.maxSizeQuestionList = maxSizeQuestionList;
        this.maxSizeSubQuestionList = maxSizeSubQuestionList;
        this.minSizeSubQuestionList = minSizeSubQuestionList;
        this.maxSizeImageList = maxSizeImageList;
        this.maxSizeSentenceList = maxSizeSentenceList;
    }

    public boolean doSomething(PartQuestionDto partQuestionDto) {
        if (!partQuestionDto.getNamePart().isEmpty()) {
            if (verifyNull(partQuestionDto.getPathFileMp3(), this.allowNullMp3)) {
                if (!this.allowNullMp3) {
                    if (partQuestionDto.getPathFileMp3().getSize() < 1) {
                        return false;
                    }
                }
                List<QuestionDto> questionDtoList = partQuestionDto.getQuestionDtoList();
                if (verifyForQuestionList(questionDtoList)) {
                    if (questionDtoList != null) {
                        for (QuestionDto questionDto : questionDtoList) {
                            List<ParagraphDto> paragraphDtoList = questionDto.getParagraphDtoList();
                            List<FileImageDto> fileImageDtoList = questionDto.getFileImageDtoList();
                            List<SubQuestionDto> subQuestionDtoList = questionDto.getSubQuestionDtoList();
                            if (verifyForParagraphList(paragraphDtoList)
                                    && verifyForFileImageList(fileImageDtoList)
                                    && verifyForSubQuestionList(subQuestionDtoList)) {
                                if (!this.allowNullParagraphList) {
                                    if (paragraphDtoList.get(0).getParagraph().isEmpty()) {
                                        return false;
                                    }
                                }
                                if (!this.allowNullFileImageList) {
                                    for (FileImageDto fileImageDto : fileImageDtoList) {
                                        if (!verifyNull(fileImageDto.getPathFileImage(), false)) {
                                            if (fileImageDto.getPathFileImage().getSize() < 1) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                                for (SubQuestionDto subQuestionDto : subQuestionDtoList) {
                                    if (subQuestionDto.getAnswer() == null
                                            || subQuestionDto.getAnswer().toString().isEmpty()) {
                                        return false;
                                    }
                                    if (!allowNullAsk) {
                                        if (subQuestionDto.getSentenceAsk().isEmpty()) {
                                            return false;
                                        }
                                    } else {
                                        if (subQuestionDto.getSentenceAsk() != null
                                                && subQuestionDto.getSentenceAsk().isEmpty()) {
                                            return false;
                                        }
                                    }
                                    List<SentenceDto> sentenceDtoList = subQuestionDto.getSentenceDtoList();
                                    if (this.verifyForSentenceList(sentenceDtoList)) {
                                        if (sentenceDtoList != null) {
                                            for (SentenceDto sentenceDto : sentenceDtoList) {
                                                if (this.allowNullSentence) {
                                                    if (sentenceDto != null) {
                                                        if (sentenceDto.getSentenceEn() != null
                                                                && sentenceDto.getSentenceEn().isEmpty()) {
                                                            return false;
                                                        }
                                                    }
                                                } else {
                                                    if (sentenceDto == null
                                                            || (sentenceDto.getSentenceEn() != null
                                                            && sentenceDto.getSentenceEn().isEmpty())) {
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    } else {
                                        return false;
                                    }
                                }
                            } else {
                                return false;
                            }
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifyForSentenceList(List<SentenceDto> sentenceDtoList) {
        if (this.verifyNull(sentenceDtoList, this.allowNullSentenceList)) {
            if (!this.allowNullSentenceList) {
                if (!sentenceDtoList.isEmpty()
                        && sentenceDtoList.size() <= this.maxSizeSentenceList) {
                    return true;
                }
            }
        } else {
            if (this.allowNullSentenceList) {
                if (!sentenceDtoList.isEmpty()
                        && sentenceDtoList.size() <= this.maxSizeSentenceList) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifyForSubQuestionList(List<SubQuestionDto> subQuestionDtoList) {
        if (verifyNull(subQuestionDtoList, false)
                && !subQuestionDtoList.isEmpty()
                && subQuestionDtoList.size() <= this.maxSizeSubQuestionList
                && subQuestionDtoList.size() >= this.minSizeSubQuestionList) {
            return true;
        }
        return false;
    }

    private boolean verifyForFileImageList(List<FileImageDto> fileImageDtoList) {
        if (this.verifyNull(fileImageDtoList, this.allowNullFileImageList)) {
            if (!this.allowNullFileImageList) {
                if (fileImageDtoList.isEmpty()
                        || fileImageDtoList.size() > maxSizeImageList) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean verifyForParagraphList(List<ParagraphDto> paragraphDtoList) {
        if (this.verifyNull(paragraphDtoList, this.allowNullParagraphList)) {
            if (!this.allowNullParagraphList) {
                if (paragraphDtoList.isEmpty()) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    private boolean verifyForQuestionList(List<QuestionDto> questionDtoList) {
        if (verifyNull(questionDtoList, this.allowNullQuestionList)) {
            if (!this.allowNullQuestionList) {
                if (!questionDtoList.isEmpty()
                        && questionDtoList.size() <= this.maxSizeQuestionList) {
                    return true;
                }
            } else {
                return true;
            }
        } else {
            if (questionDtoList != null) {
                if (!questionDtoList.isEmpty()
                        && questionDtoList.size() <= this.maxSizeQuestionList) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean verifyNull(Object object, boolean allow) {
        return (object == null) == allow;
    }

}
