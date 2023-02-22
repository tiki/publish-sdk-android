import android.content.Context
import android.graphics.Color
import android.graphics.fonts.FontFamily
import com.google.android.material.bottomsheet.BottomSheetDialog

/**
 * A dismissible bottom sheet that will be shown after the user accepts sharing its data. 
 */
class AwesomeCompletionSheet(
  context: Context,
  /**
   * The color that will be used in "your".
   */
  val accentColor : Color,

  /**
   * The text color.
   */
  val primaryColor: Color,

  /**
   * The color used in all backgrounds.
   */
  val backgroundColor: Color,

  /**
   * The fontFamily from pubspec.
   */
  val font: FontFamily
): BottomSheetDialog(context)